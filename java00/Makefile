JAR     := build/school-util.jar
CLASSES := build/classes
LIB_SRC := $(wildcard lib/school/util/*.java)
EXOS    := ex00 ex01 ex02 ex03 ex04 ex05

.PHONY: all lib clean re $(EXOS)

all: lib

lib: $(JAR)

# Rebuild the jar only when something in lib/ actually changed.
$(JAR): $(LIB_SRC)
	javac -d $(CLASSES) $(LIB_SRC)
	jar --create --file $@ -C $(CLASSES) .

# `make ex00` -> compile that exercise against the jar, then run it.
$(EXOS): $(JAR)
	javac -cp $(JAR) -d $@/bin $@/Program.java
	java -cp $(JAR):$@/bin Program

clean:
	rm -rf build $(foreach e,$(EXOS),$(e)/bin)

re: clean all
