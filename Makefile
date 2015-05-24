#$< represent the fisrt prerequisite, $@ is the target, $^ all the prerequisites.


32: 32-longest-valid-parentheses.cpp
	g++ $<  -o 32.out

20: 20-valid-parentheses.cpp
	g++ $<  -o 20.out
clean:
	rm -f *.out *.o
