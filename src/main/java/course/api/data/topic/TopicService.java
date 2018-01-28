package course.api.data.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Singleton -> creates exactly one instance for incoming requests
@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;


	// static initialisation block with param. constructors
	/*	private	List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "The Spring Framework", "Spring Framework Description"),
			new Topic("java", "Core Java", "Core Java Description"),
			new Topic("go", "GoLang", "GoLang Description")
			));
	 */
	// method to return one copy of the above single object
	/*	public List<Topic> getAllTopics() {
		return topics;
	}*/

	// topicRepository method runs a SQL query in the DB
	// returns "Iterable", single items, which we need to capture in a collection
	// Lambda: adds all the items found in above Iterable to the List
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;	
	}


	public Topic getTopic(String id) { // compares incoming with set ID above
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();  // then matches on first one found and gets it
		return topicRepository.findOne(id); //we defined the generic type in topicRepo to be a string in DB, hence the match
	}

	// adding to the ArrayList of topics
	// using out of the box TopicRepository method
	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic);
	}

	// looping through arraylist of topics via string id, if found, set new topic 
	public void updateTopic(String id, Topic topic) {
		/* for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}*/

		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		topicRepository.delete(id);;
	}
}
