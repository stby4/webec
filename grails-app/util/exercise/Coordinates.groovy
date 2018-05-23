package exercise

class Coordinates {
    long lat
    long lon

    Coordinates(long lat, long lon) {
        this.lat = lat
        this.lon = lon
    }

    Coordinates(long latDegrees, long latMinutes, long latSeconds, long lonDegrees, long lonMinutes, long lonSeconds) {
        this.lat = toDecimal(latDegrees, latMinutes, latSeconds)
        this.lon = toDecimal(lonDegrees, lonMinutes, lonSeconds)
    }

    static long toDecimal(long degrees, long minutes, long seconds) {
        return degrees + minutes / 60 + seconds / 3600
    }


    String toDms() {
        StringBuilder sb = new StringBuilder()

        sb.append(toDmsPart(Math.abs(lat)))
                .append(' ')
                .append(lat >= 0 ? 'N' : 'S')
                .append(' ')
                .append(toDmsPart(Math.abs(lon)))
                .append(' ')
                .append(lon >= 0 ? 'E' : 'W')

        return sb.toString()
    }


    private static String toDmsPart(long val) {
        int degrees = (int) val
        int minutes = (int) (60 * (val - degrees))
        int seconds = 3600 * (val - degrees) - 60 * minutes

        return String.format("%d° %d′ %d″", degrees, minutes, seconds)
    }

    @Override
    String toString() {
        return super.toString()
    }
}