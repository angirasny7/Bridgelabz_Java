package Collections.Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * Problem: Design a Voting System
 * Store candidate vote totals in a HashMap, retain candidate
 * insertion order in a LinkedHashMap, and display results sorted
 * alphabetically by candidate using a TreeMap.
 */
public class VotingSystem {
    public static void main(String[] args) {
        Map<String, Integer> votes = new HashMap<>();
        Map<String, Integer> voteOrder = new LinkedHashMap<>();

        castVote(votes, voteOrder, "Alice");
        castVote(votes, voteOrder, "Bob");
        castVote(votes, voteOrder, "Alice");
        castVote(votes, voteOrder, "Carol");
        castVote(votes, voteOrder, "Bob");
        castVote(votes, voteOrder, "Alice");

        Map<String, Integer> sortedResults = new TreeMap<>(votes);

        System.out.println("Vote totals: " + votes);
        System.out.println("Candidate insertion order: " + voteOrder);
        System.out.println("Alphabetically sorted results: " + sortedResults);
    }

    private static void castVote(Map<String, Integer> votes,
                                 Map<String, Integer> order, String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        order.put(candidate, order.getOrDefault(candidate, 0) + 1);
    }
}
