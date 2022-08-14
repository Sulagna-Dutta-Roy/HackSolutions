class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        
        if endWord not in wordList:
            return []
        
        # 1) build neighbor list for first bfs
        if beginWord not in wordList:
            wordList.append(beginWord)
        unseen = set(wordList)
        word_size = len(beginWord)
        neighbors = defaultdict(list)
        for word in wordList:
            for i in range(word_size):
                neighbors[f'{word[:i]}*{word[i+1:]}'].append(word)
        
        # 2) do first bfs and build reversed neighbors list for second bfs
        reverse_neighbors = defaultdict(list)
        n_t_h = [beginWord]
        unseen.remove(beginWord)
        while n_t_h:
            new_seen = set()
            for word in n_t_h:
                for i in range(word_size):
                    for neighbor in neighbors[f'{word[:i]}*{word[i+1:]}']:
                        if neighbor in unseen:
                            reverse_neighbors[neighbor].append(word)
                            new_seen.add(neighbor)
            n_t_h = list(new_seen)
            unseen -= new_seen
            if reverse_neighbors[endWord]:
                break
        
        # if endWord does not have reversed neigbors it is not reachable so return empty list
        if not reverse_neighbors[endWord]:
            return []
        
        # 3) do second bfs
        paths = [[endWord]]
        while True:
            new_paths = []
            for path in paths:
                last_node = path[-1]
                for reverse_neighbor in reverse_neighbors[last_node]:
                    new_paths.append(path + [reverse_neighbor])
            paths = new_paths
            if paths[0][-1] == beginWord:
                break
        
        # 4) reverse the paths
        result = []
        for path in paths:
            path.reverse()
            result.append(path)
        return result
