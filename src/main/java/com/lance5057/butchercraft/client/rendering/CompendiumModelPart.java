package com.lance5057.butchercraft.client.rendering;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Stream;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Either;
import com.mojang.math.Matrix3f;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import com.mojang.math.Vector4f;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BlockElementFace;
import net.minecraft.client.renderer.block.model.BlockFaceUV;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public final class CompendiumModelPart {
	public float x;
	public float y;
	public float z;
	public float xRot;
	public float yRot;
	public float zRot;
	public boolean visible = true;
	private final List<CompendiumModelPart.Cube> cubes;
	private final Map<String, CompendiumModelPart> children;

	public CompendiumModelPart(List<CompendiumModelPart.Cube> p_171306_, Map<String, CompendiumModelPart> p_171307_) {
		this.cubes = p_171306_;
		this.children = p_171307_;
	}

	public PartPose storePose() {
		return PartPose.offsetAndRotation(this.x, this.y, this.z, this.xRot, this.yRot, this.zRot);
	}

	public void loadPose(PartPose p_171323_) {
		this.x = p_171323_.x;
		this.y = p_171323_.y;
		this.z = p_171323_.z;
		this.xRot = p_171323_.xRot;
		this.yRot = p_171323_.yRot;
		this.zRot = p_171323_.zRot;
	}

	public void copyFrom(CompendiumModelPart p_104316_) {
		this.xRot = p_104316_.xRot;
		this.yRot = p_104316_.yRot;
		this.zRot = p_104316_.zRot;
		this.x = p_104316_.x;
		this.y = p_104316_.y;
		this.z = p_104316_.z;
	}

	public CompendiumModelPart getChild(String p_171325_) {
		CompendiumModelPart modelpart = this.children.get(p_171325_);
		if (modelpart == null) {
			throw new NoSuchElementException("Can't find part " + p_171325_);
		} else {
			return modelpart;
		}
	}
	
	public void setPos(Vector3f origin) {
		setPos(origin.x(), origin.y(), origin.z());
	}

	public void setPos(float p_104228_, float p_104229_, float p_104230_) {
		this.x = p_104228_;
		this.y = p_104229_;
		this.z = p_104230_;
	}

	public void setRotation(float p_171328_, float p_171329_, float p_171330_) {
		this.xRot = p_171328_;
		this.yRot = p_171329_;
		this.zRot = p_171330_;
	}

	public void render(PoseStack p_104302_, MultiBufferSource bufferIn, int p_104304_, int p_104305_) {
		this.render(p_104302_, bufferIn, p_104304_, p_104305_, 1.0F, 1.0F, 1.0F, 1.0F);
	}

	public void render(PoseStack p_104307_, MultiBufferSource bufferIn, int p_104309_, int p_104310_, float p_104311_,
			float p_104312_, float p_104313_, float p_104314_) {
		if (this.visible) {
			if (!this.cubes.isEmpty() || !this.children.isEmpty()) {
				p_104307_.pushPose();
				this.translateAndRotate(p_104307_);
				this.compile(p_104307_.last(), bufferIn, p_104309_, p_104310_, p_104311_, p_104312_, p_104313_,
						p_104314_);

				for (CompendiumModelPart modelpart : this.children.values()) {
					modelpart.render(p_104307_, bufferIn, p_104309_, p_104310_, p_104311_, p_104312_, p_104313_,
							p_104314_);
				}

				p_104307_.popPose();
			}
		}
	}

	public void visit(PoseStack p_171310_, CompendiumModelPart.Visitor p_171311_) {
		this.visit(p_171310_, p_171311_, "");
	}

	private void visit(PoseStack p_171313_, CompendiumModelPart.Visitor p_171314_, String p_171315_) {
		if (!this.cubes.isEmpty() || !this.children.isEmpty()) {
			p_171313_.pushPose();
			this.translateAndRotate(p_171313_);
			PoseStack.Pose posestack$pose = p_171313_.last();

			for (int i = 0; i < this.cubes.size(); ++i) {
				p_171314_.visit(posestack$pose, p_171315_, i, this.cubes.get(i));
			}

			String s = p_171315_ + "/";
			this.children.forEach((p_171320_, p_171321_) -> {
				p_171321_.visit(p_171313_, p_171314_, s + p_171320_);
			});
			p_171313_.popPose();
		}
	}

	public void translateAndRotate(PoseStack p_104300_) {
		p_104300_.translate((double) (this.x / 16.0F), (double) (this.y / 16.0F), (double) (this.z / 16.0F));
		if (this.zRot != 0.0F) {
			p_104300_.mulPose(Vector3f.ZP.rotation(this.zRot));
		}

		if (this.yRot != 0.0F) {
			p_104300_.mulPose(Vector3f.YP.rotation(this.yRot));
		}

		if (this.xRot != 0.0F) {
			p_104300_.mulPose(Vector3f.XP.rotation(this.xRot));
		}

	}

	private void compile(PoseStack.Pose p_104291_, MultiBufferSource bufferIn, int p_104293_, int p_104294_,
			float p_104295_, float p_104296_, float p_104297_, float p_104298_) {
		for (CompendiumModelPart.Cube modelpart$cube : this.cubes) {
			modelpart$cube.compile(p_104291_, bufferIn, p_104293_, p_104294_, p_104295_, p_104296_, p_104297_,
					p_104298_);
		}

	}

	public CompendiumModelPart.Cube getRandomCube(Random p_104329_) {
		return this.cubes.get(p_104329_.nextInt(this.cubes.size()));
	}

	public boolean isEmpty() {
		return this.cubes.isEmpty();
	}

	public Stream<CompendiumModelPart> getAllParts() {
		return Stream.concat(Stream.of(this),
				this.children.values().stream().flatMap(CompendiumModelPart::getAllParts));
	}

	@OnlyIn(Dist.CLIENT)
	public static class Cube {
		private final CompendiumModelPart.Polygon[] polygons;
		public final float minX;
		public final float minY;
		public final float minZ;
		public final float maxX;
		public final float maxY;
		public final float maxZ;

		public Cube(int pTexCoordU, int pTexCoordV, Vector3f from, Vector3f to, Vector3f scale, boolean mirror,
				BlockElementFace up, BlockElementFace down, BlockElementFace north, BlockElementFace south,
				BlockElementFace west, BlockElementFace east, Map<String, Either<Material, String>> textureMap) {
			this.minX = from.x();
			this.minY = from.y();
			this.minZ = from.z();

			this.maxX = to.x();
			this.maxY = to.y();
			this.maxZ = to.z();

			this.polygons = new CompendiumModelPart.Polygon[6];

			float f = to.x();
			float f1 = to.y();
			float f2 = to.z();

			float f3 = from.x();
			float f4 = from.y();
			float f5 = from.z();

			f += scale.x();
			f1 += scale.y();
			f2 += scale.z();
			if (mirror) {
				float f6 = f;
				f = from.x();
				f3 = f6;
			}

			CompendiumModelPart.Vertex modelpart$vertex7 = new CompendiumModelPart.Vertex(f3, f4, f5, 0.0F, 0.0F);
			CompendiumModelPart.Vertex modelpart$vertex = new CompendiumModelPart.Vertex(f, f4, f5, 0.0F, 8.0F);
			CompendiumModelPart.Vertex modelpart$vertex1 = new CompendiumModelPart.Vertex(f, f1, f5, 8.0F, 8.0F);
			CompendiumModelPart.Vertex modelpart$vertex2 = new CompendiumModelPart.Vertex(f3, f1, f5, 8.0F, 0.0F);
			CompendiumModelPart.Vertex modelpart$vertex3 = new CompendiumModelPart.Vertex(f3, f4, f2, 0.0F, 0.0F);
			CompendiumModelPart.Vertex modelpart$vertex4 = new CompendiumModelPart.Vertex(f, f4, f2, 0.0F, 8.0F);
			CompendiumModelPart.Vertex modelpart$vertex5 = new CompendiumModelPart.Vertex(f, f1, f2, 8.0F, 8.0F);
			CompendiumModelPart.Vertex modelpart$vertex6 = new CompendiumModelPart.Vertex(f3, f1, f2, 8.0F, 0.0F);

			if (down != null) {
				String s = down.texture.substring(1);
				Either<Material, String> test = textureMap.get(s);
				this.polygons[2] = new CompendiumModelPart.Polygon(
						new CompendiumModelPart.Vertex[] { modelpart$vertex4, modelpart$vertex3, modelpart$vertex7,
								modelpart$vertex },
						test, down.uv.uvs[0], down.uv.uvs[1], down.uv.uvs[2], down.uv.uvs[3], Direction.DOWN,
						down.uv.rotation);
			}

			if (up != null) {
				String s = up.texture.substring(1);
				Either<Material, String> test = textureMap.get(s);
				this.polygons[3] = new CompendiumModelPart.Polygon(
						new CompendiumModelPart.Vertex[] { modelpart$vertex1, modelpart$vertex2, modelpart$vertex6,
								modelpart$vertex5 },
						test, up.uv.uvs[0], up.uv.uvs[1], up.uv.uvs[2], up.uv.uvs[3], Direction.UP, up.uv.rotation);
			}

			if (west != null) {
				String s = west.texture.substring(1);
				Either<Material, String> test = textureMap.get(s);
				this.polygons[1] = new CompendiumModelPart.Polygon(
						new CompendiumModelPart.Vertex[] { modelpart$vertex7, modelpart$vertex3, modelpart$vertex6,
								modelpart$vertex2 },
						test, west.uv.uvs[0], west.uv.uvs[1], west.uv.uvs[2], west.uv.uvs[3], Direction.WEST,
						west.uv.rotation);
			}

			if (north != null) {
				String s = north.texture.substring(1);
				Either<Material, String> test = textureMap.get(s);
				this.polygons[4] = new CompendiumModelPart.Polygon(
						new CompendiumModelPart.Vertex[] { modelpart$vertex, modelpart$vertex7, modelpart$vertex2,
								modelpart$vertex1 },
						test, north.uv.uvs[0], north.uv.uvs[1], north.uv.uvs[2], north.uv.uvs[3], Direction.NORTH,
						north.uv.rotation);
			}

			if (east != null) {
				String s = east.texture.substring(1);
				Either<Material, String> test = textureMap.get(s);
				this.polygons[0] = new CompendiumModelPart.Polygon(
						new CompendiumModelPart.Vertex[] { modelpart$vertex4, modelpart$vertex, modelpart$vertex1,
								modelpart$vertex5 },
						test, east.uv.uvs[0], east.uv.uvs[1], east.uv.uvs[2], east.uv.uvs[3], Direction.EAST,
						east.uv.rotation);
			}

			if (south != null) {
				String s = south.texture.substring(1);
				Either<Material, String> test = textureMap.get(s);
				this.polygons[5] = new CompendiumModelPart.Polygon(
						new CompendiumModelPart.Vertex[] { modelpart$vertex3, modelpart$vertex4, modelpart$vertex5,
								modelpart$vertex6 },
						test, south.uv.uvs[0], south.uv.uvs[1], south.uv.uvs[2], south.uv.uvs[3], Direction.SOUTH,
						south.uv.rotation);
			}
		}

		public void compile(PoseStack.Pose pPose, MultiBufferSource bufferIn, int p_171335_, int p_171336_,
				float p_171337_, float p_171338_, float p_171339_, float p_171340_) {
			Matrix4f matrix4f = pPose.pose();
			Matrix3f matrix3f = pPose.normal();

			for (CompendiumModelPart.Polygon modelpart$polygon : this.polygons) {
				if (modelpart$polygon != null) {
					Vector3f vector3f = modelpart$polygon.normal.copy();
					vector3f.transform(matrix3f);
					float f = vector3f.x();
					float f1 = vector3f.y();
					float f2 = vector3f.z();

					for (CompendiumModelPart.Vertex modelpart$vertex : modelpart$polygon.vertices) {
						if (modelpart$polygon.texture != null) {
							if (modelpart$polygon.texture.left().isPresent()) {
								float f3 = modelpart$vertex.pos.x() / 16.0F;
								float f4 = modelpart$vertex.pos.y() / 16.0F;
								float f5 = modelpart$vertex.pos.z() / 16.0F;
								Vector4f vector4f = new Vector4f(f3, f4, f5, 1.0F);
								vector4f.transform(matrix4f);
								ResourceLocation s = new ResourceLocation(
										modelpart$polygon.texture.left().get().texture().getNamespace(), "textures/"
												+ modelpart$polygon.texture.left().get().texture().getPath() + ".png");
								bufferIn.getBuffer(RenderType.entityCutoutNoCull(s)).vertex(vector4f.x(), vector4f.y(),
										vector4f.z(), p_171337_, p_171338_, p_171339_, p_171340_,
										modelpart$vertex.u / 16, modelpart$vertex.v / 16, p_171336_, p_171335_, f, f1,
										f2);
							}
						}
					}
				}
			}

		}
	}

	@OnlyIn(Dist.CLIENT)
	static class Polygon {
		public final Either<Material, String> texture;
		public final CompendiumModelPart.Vertex[] vertices;
		public final Vector3f normal;

		public Polygon(CompendiumModelPart.Vertex[] vertices, Either<Material, String> either, float w, float x,
				float y, float z, Direction dir, int rot) {
			this.texture = either;
			this.vertices = vertices;
			boolean mirror = false;

			switch (rot) {
			case 0:
				vertices[0] = vertices[0].remap(y, x);
				vertices[1] = vertices[1].remap(w, x);
				vertices[2] = vertices[2].remap(w, z);
				vertices[3] = vertices[3].remap(y, z);
				break;

			case 90:

				vertices[0] = vertices[0].remap(y, z);
				vertices[1] = vertices[1].remap(y, x);
				vertices[2] = vertices[2].remap(w, x);
				vertices[3] = vertices[3].remap(w, z);
				break;

			case 180:

				vertices[0] = vertices[0].remap(w, z);
				vertices[1] = vertices[1].remap(y, z);
				vertices[2] = vertices[2].remap(y, x);
				vertices[3] = vertices[3].remap(w, x);
				break;

			case 270:

				vertices[0] = vertices[0].remap(w, x);
				vertices[1] = vertices[1].remap(w, z);
				vertices[2] = vertices[2].remap(y, z);
				vertices[3] = vertices[3].remap(y, x);
				break;
			}

			if (mirror) {
				int i = vertices.length;

				for (int j = 0; j < i / 2; ++j) {
					CompendiumModelPart.Vertex modelpart$vertex = vertices[j];
					vertices[j] = vertices[i - 1 - j];
					vertices[i - 1 - j] = modelpart$vertex;
				}
			}

			this.normal = dir.step();
			if (mirror) {
				this.normal.mul(-1.0F, 1.0F, 1.0F);
			}

		}
	}

	@OnlyIn(Dist.CLIENT)
	static class Vertex {
		public final Vector3f pos;
		public final float u;
		public final float v;

		public Vertex(float x, float y, float z, float u, float v) {
			this(new Vector3f(x, y, z), u, v);
		}

		public CompendiumModelPart.Vertex remap(float u, float v) {
			return new CompendiumModelPart.Vertex(this.pos, u, v);
		}

		public Vertex(Vector3f pos, float u, float v) {
			this.pos = pos;
			this.u = u;
			this.v = v;
		}
	}

	@FunctionalInterface
	@OnlyIn(Dist.CLIENT)
	public interface Visitor {
		void visit(PoseStack.Pose p_171342_, String p_171343_, int p_171344_, CompendiumModelPart.Cube p_171345_);
	}

	
}