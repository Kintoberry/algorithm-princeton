package InterviewQuestions;

import java.sql.Timestamp;

public class Log {
    private int memberID1, memberID2;
    private Timestamp timestamp;
    public Log(int id1, int id2) {
        memberID1 = id1;
        memberID2 = id2;
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    public int getFirstMemberID() {
        return memberID1;
    }
    public int getSecondMemberID() {
        return memberID2;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }
}
