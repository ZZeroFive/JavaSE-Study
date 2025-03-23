package ml.generic.study.actual04;

import lombok.Data;

@Data
public class Pair<T> {
    private T first;

    private T second;
}
