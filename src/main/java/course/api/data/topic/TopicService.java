package course.api.data.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

// Singleton -> creates exactly one instance for incoming requests
@Service
public class TopicService {
	// static initialisation block with param. constructors
	private	List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "The Spring Framework", "Spring Framework Description"),
			new Topic("java", "Core Java", "Core Java Description"),
			new Topic("go", "GoLang", "GoLang Description")
			));

	// method to return one copy of the above single object
	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(String id) { // compares incoming with set ID above
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();  // then matches on first one found and gets it
	}

	// adding to the ArrayList of topics
	public void addTopic(Topic topic) {
		topics.add(topic);

	}
	// looping through arraylist of topics via string id, if found, set new topic 
	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}
