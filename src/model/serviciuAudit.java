package model;

import contracts.ServiceContract;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

/* Serviciul prin care stochez toate operatiunile efectuate in cadrul firmei */
public class serviciuAudit {

    private static serviciuAudit audit = new serviciuAudit();

    private serviciuAudit() {}

    public static serviciuAudit getAudit() {
        if (audit == null) {
            audit = new serviciuAudit();
        }
        return audit;
    }

    public void scrie(String actiune) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                "/Users/alc/IdeaProjects/ServiceAuto/src/repository/audit.csv", true))) {
            Timestamp timp = new Timestamp(System.currentTimeMillis());
            bufferedWriter.append(actiune);
            bufferedWriter.append(",");
            bufferedWriter.append(timp.toString());
            bufferedWriter.append("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
