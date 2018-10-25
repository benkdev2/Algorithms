import java.util.*;

public class WinningCandidate {

    //Takes in an array of strings, and tallies the number of identical strings. Counts are considered votes.
    //Returns the name repeated the most times (most votes)
    //If votes are equal, returns the least string from lexographical order.
    //
    //Time complexity - worst case O(n) - using compareTo and hashcode allows us to avoid comparing the strings
    //Comparing strings would degrade the algorithm to worst case O(n^2).
    //
    //Space complexity - O(n) - potentially adding each object to a set, and we add each object to a map.
    //
    //Could definitely use cleaning up, but these solutions are meant to be within the time constraints of an interview.
    public String winningCandidate(String[] candidateNames) {
        if (candidateNames == null || candidateNames.length == 0) {
            return "";
        }
        Set<VoteCount> candidateSet = new HashSet<>();
        Map<String, Integer> candidateVoteMap = new HashMap<>();
        int maxVotes = 0;
        for (String candidateName : candidateNames) {
            if (candidateName == null) continue; //Just skip this iteration since the input is null

            Integer votes = candidateVoteMap.get(candidateName);
            if (votes == null) {
                votes = 0;
            }
            VoteCount voteCount = new VoteCount(candidateName, votes);
            votes++;
            if (votes > maxVotes) {
                maxVotes = votes;
                voteCount.incrementVoteCount();
                candidateSet.clear();
                candidateSet.add(voteCount);
            } else if (votes == maxVotes) {
                candidateSet.remove(voteCount);
                voteCount.incrementVoteCount();
                candidateSet.add(voteCount);
            }
            candidateVoteMap.put(candidateName, votes);
        }
        return computLexographicallySmallest(candidateSet);
    }

    private String computLexographicallySmallest(Set<VoteCount> candidateSet) {
        Iterator<VoteCount> itr = candidateSet.iterator();
        VoteCount winner = itr.next(); //guaranteed to have at least one VoteCount here.
        while (itr.hasNext()) {
            VoteCount nextCandidate = itr.next();
            if (nextCandidate.compareTo(winner) < 0) {
                winner = nextCandidate;
            }
        }
        return winner.getCandidateName();
    }

    private class VoteCount implements Comparable<VoteCount> {
        int votes;
        String candidateName;

        public VoteCount(String candidateName, int votes) {
            this.candidateName = candidateName;
            this.votes = votes;
        }

        public void incrementVoteCount() {
            this.votes++;
        }

        public String getCandidateName() {
            return candidateName;
        }

        public int compareTo(VoteCount otherVoteCount) {
            VoteCount voteCount = otherVoteCount;
            int result;
            boolean thisLongerThanOther = false;
            if (this.hashCode() == otherVoteCount.hashCode()) {
                return 0;
            } else if (this.getCandidateName().length() < otherVoteCount.getCandidateName().length()) {
                voteCount = new VoteCount(otherVoteCount.getCandidateName().substring(0, this.getCandidateName().length()), otherVoteCount.votes);
            } else if (this.getCandidateName().length() > otherVoteCount.getCandidateName().length()) {
                voteCount = new VoteCount(this.getCandidateName().substring(0, otherVoteCount.getCandidateName().length()), this.votes);
                thisLongerThanOther = true;
            }
            if (thisLongerThanOther && voteCount.hashCode() < otherVoteCount.hashCode()) {
                result = -1;
            } else if (thisLongerThanOther && voteCount.hashCode() == otherVoteCount.hashCode()) {
                result = 1;
            } else if (this.hashCode() < voteCount.hashCode()) {
                result = -1;
            } else {
                result = 1;
            }
            return result;
        }

        //In this system, there are only first names, so we don't need to include count.
        public boolean equals(VoteCount otherVoteCount) {
            return this.compareTo(otherVoteCount) == 0;
        }

        public int hashCode() {
            int prime = 31;
            int result = prime + votes;
            for (int i = 0; i < this.candidateName.length(); i++) {
                result = prime * result + this.candidateName.charAt(i);
            }
            return result;
        }
    }

}
