public class TunnellingTheEarth {
    public static final int RHO = 6371009;
    public static void main(String[] args) {
        System.out.println(tunnel(43.46667, -80.516667, 30.058056, 31.228889));

    }

    public static double tunnel(double lat1, double long1, double lat2, double long2) {
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        long1 = Math.toRadians(long1);
        long2 = Math.toRadians(long2);
        double x1 = (RHO * Math.sin(lat1) * Math.cos(long1));
        double y1 = (RHO * Math.sin(lat1) * Math.sin(long1));
        double z1 = (RHO * Math.cos(lat1));
        double x2 = (RHO * Math.sin(lat2) * Math.cos(long2));
        double y2 = (RHO * Math.sin(lat2) * Math.sin(long2));
        double z2 = (RHO * Math.cos(lat2));
        // distance formula
        return Math.sqrt(Math.pow(x2-x1, 2.0) +Math.pow(y2-y1, 2.0) + Math.pow(z2-z1, 2.0));
    }
}
