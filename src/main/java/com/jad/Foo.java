package com.jad;

import java.util.ArrayList;
import java.util.List;

public class Foo implements IFoo {
    private IBaz baz;
    private List<IBar> bars;
    private IQux qux;
    private ICorge corge;

    public Foo(final IBaz baz) {
        this.baz = baz;
        this.bars = new ArrayList<>();
        this.qux = new Qux();
    }

    public IBaz getBaz() {
        return this.baz;
    }

    public void addBar(final IBar bar) {
        if (bar != null) {
            this.bars.add(bar);
        }
    }

    public List<IBar> getBars() {
        return new ArrayList<>(this.bars);
    }

    public IQux getQux() {
        return this.qux;
    }

    @Override
    public ICorge getCorge() {
        return this.corge;
    }

    @Override
    public void setCorge(final ICorge corge) {
        if (this.corge != null) {
            this.corge.setFoo(null);
        }

        this.corge = corge;

        if (this.corge != null && this.corge.getFoo() != this) {
            this.corge.setFoo(this);
        }
    }
}