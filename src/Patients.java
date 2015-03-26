/**
 * Patients - records several patients
 * Created by Jason on 22/03/2015.
 */
public class Patients {
    Patient[] records;
    int current;

    public Patients(int maxSize) {
        records = new Patient[maxSize];
    }

    public int count() {
        return current;
    }

    public void add(Patient patient) {
        records[current++] = patient;
    }

    public Patient get(int i) {
        return records[i];
    }

    public boolean isFull() {
        return current == records.length;
    }

    public boolean isEmpty() {
        return current == 0;
    }
}


