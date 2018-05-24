package exercise


class Coordinates {
    static long toDecimal(long degrees, long minutes, long seconds) {
        return degrees + minutes / 60 + seconds / 3600
    }

    static String toDms(long lat, long lon) {
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


    private static String toDmsPart(long val) {
        int degrees = (int) val
        int minutes = (int) (60 * (val - degrees))
        int seconds = (int) 3600 * (val - degrees) - 60 * minutes

        return String.format("%d° %d′ %d″", degrees, minutes, seconds)
    }
}