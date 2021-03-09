package net.mgsx.gltf.loaders.gltf;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Vector3;

import net.mgsx.gltf.scene3d.scene.Scene;
import net.mgsx.gltf.scene3d.scene.SceneAsset;
import net.mgsx.gltf.scene3d.scene.SceneManager;

public class AnimationLoaderTest extends Game {

	public static void main(String[] args) {
		new LwjglApplication(new AnimationLoaderTest());
	}

	private Scene scene;
	private SceneManager sceneManager;
	private PerspectiveCamera camera;
	private SceneAsset sceneAsset;

	@Override
	public void create() {
		sceneAsset = new GLTFLoader().load(Gdx.files.classpath("gltftutorials/khronosgroup/github/simple.gltf"));
		scene = new Scene(sceneAsset.scene);
		sceneManager = new SceneManager();
		sceneManager.addScene(scene);
		
		// setup camera
		camera = new PerspectiveCamera(60f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.near = 0.01f;
		camera.far =  4000f;
		camera.position.set(0, 0, 3);
		camera.lookAt(Vector3.Zero);
		sceneManager.setCamera(camera);
	}
	
	@Override
	public void resize(int width, int height) {
		sceneManager.updateViewport(width, height);
	}
	
	@Override
	public void render() {
		float deltaTime = Gdx.graphics.getDeltaTime();
		
		camera.update();
		
		// render
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		sceneManager.update(deltaTime);
		sceneManager.render();
	}
	
	@Override
	public void dispose() {
		sceneManager.dispose();
		sceneAsset.dispose();
	}
}
