/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t_oster.jepilog.model;

import com.kitfox.svg.SVGCache;
import com.kitfox.svg.SVGUniverse;
import com.t_oster.liblasercut.IllegalJobException;
import com.t_oster.liblasercut.LaserCutter;
import com.t_oster.liblasercut.LaserJob;
import com.t_oster.liblasercut.VectorPart;
import com.t_oster.liblasercut.epilog.EpilogCutter;
import com.t_oster.liblasercut.MaterialProperty;
import com.t_oster.liblasercut.CuttingProperty;
import com.t_oster.util.Util;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.PathIterator;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author thommy
 */
public class JepilogModel extends AbstractModel implements Serializable{

    private SVGUniverse universe = SVGCache.getSVGUniverse();
    private URI uri;
    private String jobname = "testjob";
    private List<CuttingShape> vectorShapes = new LinkedList<CuttingShape>();
    private Point startPoint = new Point(0,0);
    private int resolution = 500;
    private MaterialProperty material = null;
    
    public static final String PROPERTY_STARTPOINT = "startPoint";
    public static final String PROPERTY_STARTPOSITION = "startPosition";
    public static final String PROPERTY_SVG = "svg";
    public static final String PROPERTY_RESOLUTION = "resolution";
    public static final String PROPERTY_CUTTER = "cutter";
    public static final String PROPERTY_CUTTINGSHAPES = "cuttingShapes";
    public static final String PROPERTY_MATERIAL = "material";
    
    public void setMaterial(MaterialProperty p){
        if (Util.differ(p, this.material)){
            MaterialProperty old = this.material;
            this.material = p;
            this.pcs.firePropertyChange(PROPERTY_MATERIAL, old, this.material);
        }
    }
    
    public MaterialProperty getMaterial(){
        return this.material;
    }
    
    public void setSvg(URI uri) {
        if (Util.differ(uri, this.uri)){
            URI old = this.uri;
            this.uri = uri;
            this.clearCuttingShapes();
            this.pcs.firePropertyChange(PROPERTY_SVG, old, uri);
        }
    }
    
    public URI getSvg(){
        return this.uri;
    }
    
    public void importSVG(File svgDocument) throws IOException{
        setSvg(universe.loadSVG(svgDocument.toURI().toURL()));
        jobname = svgDocument.getName();
    }

    public void addCuttingShape(Shape s) {
        this.addCuttingShape(new CuttingShape(s,null));
    }
    
    public void addCuttingShape(Shape s, CuttingProperty p){
        this.addCuttingShape(new CuttingShape(s, p));
    }
    
    public void addCuttingShape(CuttingShape s){
        if (!vectorShapes.contains(s)){
            Shape[] old = this.getCuttingShapes();
            vectorShapes.add(s);
            this.pcs.firePropertyChange(PROPERTY_CUTTINGSHAPES, old, this.getCuttingShapes());
        }
    }
    
    public void removeCuttingShape(Shape s){
        if (vectorShapes.contains(s)){
            Shape[] old = this.getCuttingShapes();
            vectorShapes.remove(s);
            this.pcs.firePropertyChange(PROPERTY_CUTTINGSHAPES, old, this.getCuttingShapes());
        }
    }
    
    public void clearCuttingShapes(){
        if (vectorShapes.size() > 0){
            Shape[] old = this.getCuttingShapes();
            vectorShapes.clear();
            this.pcs.firePropertyChange(PROPERTY_CUTTINGSHAPES, old, this.getCuttingShapes());
        }
    }

    public CuttingShape getCuttingShape(int idx){
        return vectorShapes.get(idx);
    }
    
    public void setCuttingShape(int idx, CuttingShape s){
        vectorShapes.set(idx, s);
        this.pcs.firePropertyChange(PROPERTY_CUTTINGSHAPES, null, null);
    }
    
    public CuttingShape[] getCuttingShapes() {
        return vectorShapes.toArray(new CuttingShape[0]);
    }

    public void setStartPoint(Point p){
        if (Util.differ(this.startPoint, p)){
            Point old = this.startPoint;
            String oldsp = this.getStartPosition();
            this.startPoint = p;
            this.pcs.firePropertyChange(PROPERTY_STARTPOINT, old, this.startPoint);
            String newsp = this.getStartPosition();
            if (!oldsp.equals(newsp)){
                pcs.firePropertyChange(PROPERTY_STARTPOSITION, oldsp, newsp);
            }
        }
    }
    
    private void setStartPoint(int x, int y){
        setStartPoint(new Point(x, y));
    }
    
    public Point getStartPoint(){
        return this.startPoint;
    }
    
    public String getStartPosition(){
        if (universe == null || uri == null){
            return "custom";
        }
        int w = (int) universe.getDiagram(uri).getWidth();
        int h = (int) universe.getDiagram(uri).getHeight();
        Point sp = this.getStartPoint();
        if (sp.equals(new Point(0,0))){
            return "top left";
        }
        else if (sp.equals(new Point(w,0))){
            return "top right";
        }
        else if (sp.equals(new Point(0,h))){
            return "bottom left";
        }
        else if (sp.equals(new Point(w,h))){
            return "bottom right";
        }
        else if (sp.equals(new Point(w/2,h/2))){
            return "center";
        }
        else{
            return "custom";
        }
    }
    
    public void setStartPosition(String p){
        if (Util.differ(p, this.getStartPosition())){
            String old = this.getStartPosition();
            int w = (int) (universe != null && uri != null ? universe.getDiagram(uri).getWidth() : 100);
            int h = (int) (universe != null && uri != null ? universe.getDiagram(uri).getHeight() : 100);
            if (p.equals("top left")){
                this.setStartPoint(0, 0);
            }
            else if (p.equals("top right")){
                this.setStartPoint(w, 0);
            }
            else if (p.equals("bottom left")){
                this.setStartPoint(0, h);
            }
            else if (p.equals("bottom right")){
                this.setStartPoint(w, h);
            }
            else if (p.equals("center")){
                this.setStartPoint(w/2, h/2);
            }
            pcs.firePropertyChange(PROPERTY_STARTPOSITION, old, p);
        }
    }
    
    private void addShape(VectorPart vp, Shape s) {
        PathIterator iter = s.getPathIterator(null, 1);
        while (!iter.isDone()) {
            double[] test = new double[8];
            int result = iter.currentSegment(test);
            if (result == PathIterator.SEG_MOVETO) {
                vp.moveto((int) test[0], (int) test[1]);
            } else if (result == PathIterator.SEG_LINETO) {
                vp.lineto((int) test[0], (int) test[1]);
            }
            iter.next();
        }
    }

    private VectorPart generateVectorPart() throws IllegalJobException {
        if (this.material == null){
            throw new IllegalJobException("No material selected");
        }
        CuttingProperty defaultcp = material.getCuttingProperty();
        
        VectorPart vp = new VectorPart(defaultcp);
        
        for (CuttingShape s:this.getCuttingShapes()){
            CuttingProperty cp = s.getCuttingProperty();
            vp.setCurrentCuttingProperty(cp != null ? cp : defaultcp);
            this.addShape(vp, s);
        }
        return vp;
    }

    public LaserCutter getSelectedLaserCutter() {
        EpilogCutter.SIMULATE_COMMUNICATION = false;
        return new EpilogCutter("137.226.56.228");
    }
    
    public int getResolution(){
        return resolution;
    }
    
    public void setResolution(int resolution){
        if (resolution != this.resolution){
            int old = this.resolution;
            this.resolution = resolution;
            pcs.firePropertyChange(PROPERTY_RESOLUTION, old, this.resolution);
        }
    }

    public void sendToCutter() throws IllegalJobException, Exception {
        LaserCutter cutter = this.getSelectedLaserCutter();
        if (cutter == null){
            throw new Exception("No Lasercutter selected");
        }
        if (this.getCuttingShapes().length==0){
            throw new Exception("Nothing selected for cutting");
        }
        LaserJob job = new LaserJob(jobname, "123", "bla", getResolution(), generateVectorPart());
        job.setStartPoint((int) this.getStartPoint().getX(), (int) this.getStartPoint().getY());
        cutter.sendJob(job);
    }
}