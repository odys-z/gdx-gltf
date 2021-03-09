package net.mgsx.gltf.data.animation;

import com.badlogic.gdx.utils.Array;

import net.mgsx.gltf.data.GLTFEntity;

/**Java type of {samplers[], channels[]},
 * where sampler is {@link GLTFAnimationChannel} &amp; {@link GLTFAnimationSampler>}
 */
public class GLTFAnimation extends GLTFEntity {
	public Array<GLTFAnimationChannel> channels;
	public Array<GLTFAnimationSampler> samplers;
}
