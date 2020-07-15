class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // create a logs list ["user", "time", "page"]
        List<List<String>> logs = new ArrayList<>();
        for (int i = 0; i < username.length; i++) {
            List<String> log = new ArrayList<>();
            log.add(username[i]);
            log.add(String.valueOf(timestamp[i]));
            log.add(website[i]);
            logs.add(log);
        }

        // sort logs list by the time, index 1 is time
        Collections.sort(logs, (l1, l2) -> Integer.valueOf(l1.get(1)) - Integer.valueOf(l2.get(1)));

        // create user -> List<page> map
        Map<String, List<String>> users = new HashMap<>();
        for (int i = 0; i < logs.size(); i++) {
            List<String> log = logs.get(i);
            List<String> pageList = users.getOrDefault(log.get(0), new ArrayList<>());
            pageList.add(log.get(2));
            users.put(log.get(0), pageList);
        }

        // create a 3-sequence -> count map
        Map<String, Integer> counts = new HashMap<>();
        int maxCount = 0;
        // keep tracking of the most frequent one
        String freqString = "";
        for (String user : users.keySet()) {
            Set<String> seqs = getAllSequence(users.get(user));
            // user visits less than 3 pages
            if (seqs == null) continue;
            for (String seq : seqs) {
                int count = counts.getOrDefault(seq, 0);
                counts.put(seq, ++count);
                if (count > maxCount) {
                    freqString = seq;
                    maxCount = count;
                } else if (count == maxCount) {
                    // pick word with smaller lexical order
                    freqString = seq.compareTo(freqString) < 0 ? seq : freqString;
                }
            }
        }
        return Arrays.asList(freqString.split(","));
    }

    // given a list of pages, return all the 3-sequence for a single user
    // use set to avoid duplicated 3-sequence for the same user
    // pick each page that comes after the previous one
    // join 3-pages by "," and add to the set
    // NOTE: Do not use Regex symbol such as ". * + ?"!!!!
    private Set<String> getAllSequence(List<String> list) {
        int len = list.size();
        // can not form a 3-sequence
        if (len < 3) return null;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    StringBuilder sb = new StringBuilder(list.get(i));
                    sb.append(',');
                    sb.append(list.get(j));
                    sb.append(',');
                    sb.append(list.get(k));
                    set.add(sb.toString());
                }
            }
        }
        return set;
    }
}