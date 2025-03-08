CC = gcc
CFLAGS = -Wall -Wextra -g
SRC = src/linked_list.c src/array_list.c src/hash_map.c src/bst_tree.c src/main.c
OBJ = $(SRC:.c=.o)
EXEC = main

all: $(EXEC)

$(EXEC): $(OBJ)
	$(CC) $(CFLAGS) -o $(EXEC) $(OBJ)

%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

clean:
	rm -f $(OBJ) $(EXEC)

