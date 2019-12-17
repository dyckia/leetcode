class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (paths == null || paths.length == 0) return res;
        // content -> index in res
        Map<String, List<String>> contentMap = new HashMap<>();
        for (String p : paths) {
            // first element is path, rest are files
            String[] arr = p.split(" ");
            String path = arr[0];
            for (int i = 1; i < arr.length; i++) {
                String file = arr[i];
                String[] nameAndContent = extractContent(file);
                String filePath = path + "/" + nameAndContent[0];
                List<String> list = contentMap.getOrDefault(nameAndContent[1], new ArrayList<String>());
                list.add(filePath);
                contentMap.put(nameAndContent[1], list);
            }
        }
        
        // add list whose size > 1 to res
        for (List<String> list : contentMap.values()) {
            if (list.size() > 1) res.add(list);
        }
        return res;
    }
    
    // extract the content from the file
    // 0-th element is file name
    // 1-st element is the content
    private String[] extractContent(String file) {
        String[] nameAndContent = new String[2];
        int openInd = file.indexOf("(");
        // file name
        nameAndContent[0] = file.substring(0, openInd);
        // file content 
        nameAndContent[1] = file.substring(openInd + 1, file.length() - 1);
        return nameAndContent;
    }
}