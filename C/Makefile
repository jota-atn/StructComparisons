CXX = g++
CXXFLAGS = -m64 -Iinclude/cpp
SRC_DIR = src/cpp
TESTS_DIR = tests
BIN_DIR = bin

$(shell mkdir -p $(BIN_DIR))

all: arraylist linkedlist hashmap

arraylist: $(TESTS_DIR)/arraylist/main.cpp $(TESTS_DIR)/arraylist/output.cpp $(SRC_DIR)/array_list.cpp
	$(CXX) $(CXXFLAGS) -o $(BIN_DIR)/arraylist_exec $^

linkedlist: $(TESTS_DIR)/linkedlist/main.cpp $(TESTS_DIR)/linkedlist/output.cpp $(SRC_DIR)/linked_list.cpp
	$(CXX) $(CXXFLAGS) -o $(BIN_DIR)/linkedlist_exec $^

hashmap: $(TESTS_DIR)/hashmap/main.cpp $(TESTS_DIR)/hashmap/output.cpp $(SRC_DIR)/hash_map.cpp
	$(CXX) $(CXXFLAGS) -o $(BIN_DIR)/hashmap_exec $^

clean:
	rm -rf $(BIN_DIR)/*
