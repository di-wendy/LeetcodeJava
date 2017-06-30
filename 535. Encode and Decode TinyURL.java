public class Codec {

    private HashMap<Integer,String> hm = new HashMap<Integer,String>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(!hm.containsValue(longUrl)) {
            hm.put(hm.size() + 1,longUrl);
        }
        return "http://tinyurl.com/" + Integer.toString(hm.size());
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] words = shortUrl.split("/");
        int code = Integer.valueOf(words[words.length - 1]);
        return hm.get(code);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));