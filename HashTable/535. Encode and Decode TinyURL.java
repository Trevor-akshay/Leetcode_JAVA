public class Codec {

    // Encodes a URL to a shortened URL.
    Map<String,String> map = new HashMap<>();
    public String encode(String longUrl) {
        String hashcode = longUrl.hashCode()+"";
        map.put(hashcode,longUrl);
        
        return hashcode;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));