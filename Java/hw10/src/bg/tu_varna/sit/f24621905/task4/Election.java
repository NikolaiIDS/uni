package bg.tu_varna.sit.f24621905.task4;

import java.util.*;

public class Election {
    private String dateofElection;
    private Map<Candidacy, Integer> results;

    public Election(String dateofElection) {
        this.dateofElection = dateofElection;
        this.results = new HashMap<>();
    }

    public void addResult(Candidacy candidacy, Integer votes) {
        results.put(candidacy, votes);
    }

    public void printOrderedByCandidacyId() {
        List<Map.Entry<Candidacy, Integer>> list = new ArrayList<>(results.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Candidacy, Integer>>() {
            @Override
            public int compare(Map.Entry<Candidacy, Integer> o1, Map.Entry<Candidacy, Integer> o2) {
                return Integer.compare(o1.getKey().getCandidacyId(), o2.getKey().getCandidacyId());
            }
        });

        for (Map.Entry<Candidacy, Integer> entry : list) {
            System.out.println(entry.getKey() + " - Votes: " + entry.getValue());
        }
    }

    public void printOrderedByVotes() {
        List<Map.Entry<Candidacy, Integer>> list = new ArrayList<>(results.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Candidacy, Integer>>() {
            @Override
            public int compare(Map.Entry<Candidacy, Integer> o1, Map.Entry<Candidacy, Integer> o2) {
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        });

        for (Map.Entry<Candidacy, Integer> entry : list) {
            System.out.println(entry.getKey() + " - Votes: " + entry.getValue());
        }
    }

    public int getVotesByPerson(Person person) {
        for (Map.Entry<Candidacy, Integer> entry : results.entrySet()) {
            Candidacy c = entry.getKey();
            if (c.getCandidatePresident().equals(person) || c.getCandidateVicePresident().equals(person)) {
                return entry.getValue();
            }
        }
        return 0;
    }

    public void getUnsupportedCandidacies() {
        for (Candidacy c : results.keySet()) {
            if (c.getParty() == Party.NONE) {
                System.out.println(c);
            }
        }
    }

    public void calculateElectionResults() {
        if (results.isEmpty()) return;

        int totalVotes = 0;
        int maxVotes = -1;
        Candidacy winner = null;

        for (Map.Entry<Candidacy, Integer> entry : results.entrySet()) {
            int currentVotes = entry.getValue();
            totalVotes += currentVotes;

            if (currentVotes > maxVotes) {
                maxVotes = currentVotes;
                winner = entry.getKey();
            }
        }

        if (maxVotes > totalVotes / 2.0) {
            System.out.println(winner + " са изборът на нацията");
        } else {
            System.out.println("Преминава се към втори тур на изборите");
        }
    }
}