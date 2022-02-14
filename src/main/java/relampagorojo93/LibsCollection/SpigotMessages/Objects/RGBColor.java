package relampagorojo93.LibsCollection.SpigotMessages.Objects;

public class RGBColor {
	private int r, g, b;
	public RGBColor(int r, int g, int b) { this.r = r; this.g = g; this.b = b; }
	public int getRed() { return r; }
	public int getGreen() { return g; }
	public int getBlue() { return b; }
	public String toSpigotColor() { return "&#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b); }
}
