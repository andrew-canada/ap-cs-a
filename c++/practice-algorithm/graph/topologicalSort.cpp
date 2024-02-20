/*
topological sort: order the vertices of a directed graph by precedence
1. build adjacency list (store node2)
2. dfs on adjacency list
    a) try each node as starting point. if not visited, dfs.
    b) keep track of visited and active nodes
    c) if dfs is visiting an already active node, topological sort is impossible
*/

#include <bits/stdc++.h>

using namespace std;

#define pb push_back

typedef long long ll;

const int mxN = 100, M = 1e9 + 7;

vector<int> adjL[mxN + 1], ans;
bool vis[mxN + 1], act[mxN + 1];

void dfs(int u)
{
    vis[u] = act[u] = true;
    for (int v : adjL[u])
    {
        if (act[v])
        {
            cout << "IMPOSSIBLE\n";
            exit(0);
        }
        else if (!vis[v])
        {
            dfs(v);
        }
    }
    act[u] = false;
    ans.pb(u);
}

int main()
{
    int n, m;
    cin >> n >> m;
    for (int i = 0, u, v; i < m; i++)
    {
        cin >> u >> v;
        adjL[u].pb(v);
    }
    for (int i = 1; i <= n; i++)
    {
        if (!vis[i])
        {
            dfs(i);
        }
    }
    reverse(ans.begin(), ans.end());
    for (int i : ans)
    {
        cout << i << " ";
    }
}

/*
4 3
1 2
2 3
2 4
*/