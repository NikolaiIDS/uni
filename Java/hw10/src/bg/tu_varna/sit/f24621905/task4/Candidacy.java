package bg.tu_varna.sit.f24621905.task4;

import java.util.Objects;

public class Candidacy {
    private int candidacyId;
    private Person candidatePresident;
    private Person candidateVicePresident;
    private Party party;

    public Candidacy(int candidacyId, Person candidatePresident, Person candidateVicePresident, Party party) {
        this.candidacyId = candidacyId;
        this.candidatePresident = candidatePresident;
        this.candidateVicePresident = candidateVicePresident;
        this.party = party;
    }

    public int getCandidacyId() {
        return candidacyId;
    }

    public Person getCandidatePresident() {
        return candidatePresident;
    }

    public Person getCandidateVicePresident() {
        return candidateVicePresident;
    }

    public Party getParty() {
        return party;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidacy candidacy = (Candidacy) o;
        return candidacyId == candidacy.candidacyId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidacyId);
    }

    @Override
    public String toString() {
        return "Ballot #" + candidacyId + ": " + candidatePresident + " & " + candidateVicePresident + " [" + party + "]";
    }
}