// save each time stamp as a Time instance
// implement Comparable interface and create getDiff method
// sort the list of time instances using Collections.sort()
// add first node to the last of the list (add 24 to the hour)

class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Time> timeList = new ArrayList<>();
        for (String time : timePoints) {
            timeList.add(new Time(Integer.valueOf(time.substring(0, 2)), Integer.valueOf(time.substring(3, 5))));
        }
        Collections.sort(timeList);
        Time first = timeList.get(0);
        timeList.add(new Time(first.hour + 24, first.minute));
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < timeList.size(); i++) {
            // compare current with previous
            int curDiff = timeList.get(i).getDiff(timeList.get(i - 1));
            minDiff = Math.min(minDiff, curDiff);
        }
        return minDiff;
    }
}

class Time implements Comparable<Time> {
    int hour;
    int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public int compareTo(Time other) {
        return getDiff(other);
    }

    public int getDiff(Time other) {
        return this.hour * 60 + this.minute - (other.hour * 60 + other.minute);
    }
}