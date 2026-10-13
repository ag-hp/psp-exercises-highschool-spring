package org.ies.tierno.writers;

import java.io.IOException;

public interface Writer<T> {
    void write(T v) throws IOException;
}
