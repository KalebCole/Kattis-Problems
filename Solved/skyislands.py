from collections import defaultdict
class BidirectionalGraph:
    
    def __init__(self) -> None:
        self.graph = defaultdict(list)
        
    def addEdge(self, u, v) -> None:
        self.graph[u].append(v)
        self.graph[v].append(u)
        
    def dfsUntilConnected(self, node, visited) -> bool:
        visited.add(node) # visited current node
        for neighbor in self.graph[node]:
            if neighbor not in visited: # check if neighbor is not visited
                self.dfsUntilConnected(neighbor, visited)
        return len(visited) == len(self.graph) # visited all nodes
        
    
    def isConnectedGraph(self) -> bool:
        return self.dfsUntilConnected(1, {1})

def get_input(graph):
    nodes, edges = [int(x) for x in input().split(" ")]
    if edges < nodes-1:
        print("NO")
        exit()
    for _ in range(edges):
        start, end = [int(x) for x in input().split(" ")]
        graph.addEdge(start, end)

def main() -> None:
    graph = BidirectionalGraph()
    get_input(graph)
    if graph.isConnectedGraph():
        print("YES")
    else:
        print("NO")
    
if __name__ == "__main__":
    main()