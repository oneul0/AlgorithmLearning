/* <HeuristicClass.h> */

#pragma once

#include "TypeDecl.h"
#include <vector>
#include <stack>
#include <set>
#include <queue>
#include <cmath>

class HeuristicClass {
    private: 
        struct less
        {
            constexpr bool operator()(const CostCoord& _Left, const CostCoord& _Right) const {
                return _Left.cost < _Right.cost;
            }
        };

    public:
        HeuristicClass();
        HeuristicClass(const HeuristicClass&);
        ~HeuristicClass();

        bool BeginSearch(PointDecl, Vec2MapInfo);
        std::queue<Coord> GetQueue();
    
    private:
        bool isUnBlockedNode(PointDecl, Vec2Map, int, int);
        bool isDestinationNode(int, int, int, int);
        bool isInGround(int, int, int, int);
        void TraceMinimumPath(std::vector<std::vector<CellDetails>>, Coord);
    
    private:
        const int m_dx1[4] = {0, 0, 1, -1};
        const int m_dy1[4] = {-1, 1, 0, 0};

        const int m_dx2[4] = {1, -1, -1, 1};
        const int m_dy2[4] = {-1, 1, -1, 1};

        std::queue<Coord> m_TrackedPath;
    
};