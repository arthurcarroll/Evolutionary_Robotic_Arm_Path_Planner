package main;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.post.SceneProcessor;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.texture.FrameBuffer;

/**
 *
 * Draws only the wire-frame for all models when this is active
 * @author Arthur Carroll
 */
public class WireProcessor implements SceneProcessor {

    RenderManager renderManager;
    AssetManager assetManager;
    Material wireMaterial;

    public WireProcessor(AssetManager assetManager, ColorRGBA color) {
        this.assetManager = assetManager;
        wireMaterial = new Material(assetManager, "/Common/MatDefs/Misc/WireColor.j3md");
        wireMaterial.setColor("m_Color", color);
    }

    public void initialize(RenderManager rm, ViewPort vp) {
        renderManager = rm;
    }

    public void reshape(ViewPort vp, int w, int h) {
    }

    public boolean isInitialized() {
        return renderManager != null;
    }

    public void preFrame(float tpf) {
    }

    public void postQueue(RenderQueue rq) {
        renderManager.setForcedMaterial(wireMaterial);
    }

    public void postFrame(FrameBuffer out) {
        renderManager.setForcedMaterial(null);
    }

    public void cleanup() {
        renderManager.setForcedMaterial(null);
    }
}
