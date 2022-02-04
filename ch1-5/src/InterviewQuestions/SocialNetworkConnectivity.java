/**
 *  Question 1
 * Social network connectivity. Given a social network containing n members
 * and a log file containing m timestamps at which times pairs of members formed
 * friendships, design an algorithm to determine the earliest time at which all
 * members are connected (i.e., every member is a friend of a friend of
 * a friend ... of a friend). Assume that the log file is sorted by timestamp and
 * that friendship is an equivalence relation. The running time of your algorithm
 * should be m*log(n) or better and use extra space proportional to nn.
 */

/*
Solution:
    <logic>
    Use UnionFind algorithms. Use records in the logfile to call m union() calls (loop).
    Each call to union() should be followed by count() call to see if it returns 1.
    If it returns 1, then all members are connected. At this point, printout the timestamp
    and exit the loop.

    Below is a client code to implement this idea.

    <efficiency>
    upper bound should be mlogn. If we use WeightedQuickUnionUF, then this solution makes
    m calls to union(), which is O(log(n)). Thus, O(m*log(n)).

    If you want to make it better, than you can use Weighted Quick Union with Paths compression.
 */

/*
Interesting question arise from this question:
When you have N members and M timestamps at which times pairs of members formed
friendships, determine with which number of M can we say with high certainty that
N members are all connected.

Below, somewhere around m >= 260 seems to make it such a case.

You could devise a simple problem to loop through various configurations to find out the magic number 'm'.
 */

package InterviewQuestions;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.sql.Time;
import java.sql.Timestamp;

public class SocialNetworkConnectivity {

    public static void main(String[] args) {
        int n = 100; // the number of members in a social network
        int m = 260; // m timestamps
        Log[] logs = new Log[m];
        // create an arbitrary log file
        for (int i = 0; i < logs.length; i++) {
            logs[i] = new Log(StdRandom.uniform(100), StdRandom.uniform(100)); // not handling when two IDs are the same
        }
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
        for (int i = 0; i < logs.length; i++) {
            uf.union(logs[i].getFirstMemberID(), logs[i].getSecondMemberID());
            if (uf.count() == 1) {
                System.out.println("All members are connected at: " + logs[i].getTimestamp());
                System.exit(0);
            }
        }
        System.out.println("Not all members are connected.");

    }
}

