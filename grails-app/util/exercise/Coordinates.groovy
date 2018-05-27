package exercise


class Coordinates {
    static long toDecimal(double degrees, double minutes, double seconds) {
        return degrees + minutes / 60 + seconds / 3600
    }

    static String toDms(double lat, double lon) {
        def sb = new StringBuilder()

        sb.append(toDmsPart(Math.abs(lat)))
                .append(' ')
                .append(lat >= 0 ? 'N' : 'S')
                .append(' ')
                .append(toDmsPart(Math.abs(lon)))
                .append(' ')
                .append(lon >= 0 ? 'E' : 'W')

        return sb.toString()
    }


    private static String toDmsPart(double val) {
        int degrees = (int) val
        int minutes = (int) (60 * (val - degrees))
        int seconds = (int) 3600 * (val - degrees) - 60 * minutes

        return String.format("%d° %d′ %d″", degrees, minutes, seconds)
    }
}