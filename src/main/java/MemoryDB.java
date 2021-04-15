import java.util.HashMap;

public class MemoryDB {

    private static final HashMap<String, RssDataList> memoryRepository = new HashMap<String, RssDataList>();

    public String save(String mainLink, RssDataList rssDataList) {
        memoryRepository.put(mainLink, rssDataList);

        return mainLink;
    }

    public RssDataList findById(String id) {
        return memoryRepository.get(id);
    }
}
