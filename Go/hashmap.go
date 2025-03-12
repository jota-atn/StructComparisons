package main

// HashMap implementa um mapa de hash simples
type HashMap struct {
	hashmap map[string]interface{}
	size    int
}

// NewHashMap cria um novo mapa de hash vazio
func NewHashMap() *HashMap {
	return &HashMap{
		hashmap: make(map[string]interface{}),
		size:    0,
	}
}

// Len retorna o tamanho do mapa
func (h *HashMap) Len() int {
	return h.size
}

// IsEmpty verifica se o mapa está vazio
func (h *HashMap) IsEmpty() bool {
	return h.size == 0
}

// Put insere um par chave-valor no mapa
func (h *HashMap) Put(key string, value interface{}) {
	if existingValue, exists := h.hashmap[key]; exists {
		if value != existingValue {
			h.hashmap[key] = value
		}
	} else {
		h.hashmap[key] = value
		h.size++
	}
}

// Pop remove e retorna um valor pelo sua chave
func (h *HashMap) Pop(key string) interface{} {
	if h.IsEmpty() {
		return "Empty HashMap!"
	}
	
	if removed, exists := h.hashmap[key]; exists {
		delete(h.hashmap, key)
		h.size--
		return removed
	}
	
	return "Key not found"
}

// Get retorna o valor associado a uma chave
func (h *HashMap) Get(key string) interface{} {
	if h.IsEmpty() {
		return "Empty HashMap!"
	}
	
	if value, exists := h.hashmap[key]; exists {
		return value
	}
	
	return "Key not found"
}

// ContainsKey verifica se o mapa contém a chave especificada
func (h *HashMap) ContainsKey(key string) bool {
	_, exists := h.hashmap[key]
	return exists
}

// ContainsValue verifica se o mapa contém o valor especificado
func (h *HashMap) ContainsValue(value interface{}) bool {
	for _, v := range h.hashmap {
		if v == value {
			return true
		}
	}
	return false
}