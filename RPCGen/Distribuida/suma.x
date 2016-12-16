struct intpair {
        int a;
        int b;
};

program SUMA_PROG {
        version SUMA_VERS {
                int SUMA(intpair) = 1;
        } = 1;
} = 0x23451111;
