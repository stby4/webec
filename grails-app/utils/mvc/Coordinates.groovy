package mvc

class Coordinates {
    long lat
    long lon
    int msl

    long toDecimal(long degrees, long minutes, long seconds) {
        return degrees + minutes / 60 + seconds / 3600
    }


    String toDms() {
        StringBuilder sb = new StringBuilder();

        sb.append(toDmsPart(Math.abs(lat)))
                .append(' ')
                .append(lat >= 0 ? 'N' : 'S')
                .append(' ')
                .append(toDmsPart(Math.abs(lon)))
                .append(' ')
                .append(lon >= 0 ? 'E' : 'W')
                .append(", ")
                .append(msl)
                .append(" m MSL")

        return sb.toString()
    }


    private String toDmsPart(long val) {
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