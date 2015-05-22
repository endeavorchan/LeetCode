#$< represent the fisrt prerequisite, $@ is the target, $^ all the prerequisites.


32: 32-longest-valid-parentheses.cpp
	g++ $< main.cpp  -o 32.out

clean:
	rm -f *.out *.o
