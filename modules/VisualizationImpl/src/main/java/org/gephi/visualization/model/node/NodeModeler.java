/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gephi.visualization.model.node;

import org.gephi.graph.api.Node;
import org.gephi.visualization.api.initializer.Modeler;
import org.gephi.visualization.opengl.CompatibilityEngine;

/**
 *
 * @author mbastian
 */
public abstract class NodeModeler extends Modeler {

    public NodeModeler(CompatibilityEngine engine) {
        super(engine);
    }

    public abstract NodeModel initModel(Node n);

    public abstract boolean is3d();

    protected void setViewportPosition(NodeModel object) {
        double[] res = controller.getDrawable().myGluProject(object.getNode().x(), object.getNode().y(), object.getNode().z());
        object.setViewportX((float) res[0]);
        object.setViewportY((float) res[1]);

        res = controller.getDrawable().myGluProject(object.getNode().x() + (object.getNode().size() / 2f), object.getNode().y(), object.getNode().z());
        float rad = Math.abs((float) res[0] - object.getViewportX());
        object.setViewportRadius(rad);
    }
}
