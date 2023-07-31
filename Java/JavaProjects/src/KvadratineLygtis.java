public class KvadratineLygtis {
    float a, b, c;
    float[] x;

    public KvadratineLygtis(float a1, float b1, float c1)
    {
        a = a1;
        b = b1;
        c = c1;
        x = new float[2];
    }

    public float diskr() { return b * b - 4 * a * c; }

    public float[] saknys() {
        float d = diskr();
        if (d < 0) {
            return null;
        }
        float sqD = (float) Math.sqrt(d);
        x[0] = (-b + sqD) / (2 * a);
        x[1] = (-b + sqD) / (2 * a);
        return x;
    }
}
