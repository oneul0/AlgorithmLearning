/* <HeuristicClass.cpp> */

#include "HeuristcClass.h"

HeuristicClass::HeuristicClass(){
    return;
}

HeuristicClass::HeuristicClass(const HeuristicClass&){
    return;
}

HeuristicClass::~HeuristicClass(){
    return;
}

bool HeuristicClass::BeginSearch(PointDecl ptDecl, Vec2MapInfo mapInfo){
    if(this->isDestinationNode(mapInfo.dest_x, mapInfo.dest_y, mapInfo.beg_x, mapInfo.beg_y)){
        return true;
    }
    if (!this->isUnBlockedNode(ptDecl, mapInfo.mapInfo, mapInfo.beg_x, mapInfo.beg_y) || !this->isUnBlockedNode(ptDecl, mapInfo.mapInfo, mapInfo.beg_x, mapInfo.beg_y)){
        return false;
    }
    if(!this->isInGround(mapInfo.map_col, mapInfo.map_row, mapInfo.beg_x, mapInfo.beg_y) || !this->isInGround(mapInfo.map_col, mapInfo.map_row, mapInfo.beg_x, mapInfo.beg_y)){
        return false;
    }
    int st_x = mapInfo.beg_x;
    int st_y = mapInfo.beg_y;

    std::vector<std::vector<CellDetails>> cell(mapInfo.map_row, std::vector<CellDetails>(mapInfo.map_col));
    for(int y = 0; y<mapInfo.map_row; y++){
        for(int x = 0; x<mapInfo.map_col; x++){
            cell[y][x].f = cell[y][x].g = cell[y][x].h = INF;
            cell[y][x].parent_x = cell[y][x].parent_y = -1;
        }
    }
    cell[st_y][st_x].f = cell[st_y][st_x].g = cell[st_y][st_x].h = 0.0f;
    cell[st_y][st_x].parent_x = st_x;
    cell[st_y][st_x].parent_y = st_y;

    std::vector<std::vector<bool>> closedList(mapInfo.map_row, std::vector<bool>(mapInfo.map_col));

    CostCoord bVertex;
    bVertex.cost = 0.0f;
    bVertex.x = st_x;
    bVertex.y = st_y;

    std::set<CostCoord, less> openList;
    openList.insert(bVertex);
    while (!openList.empty()) {
		CostCoord current = *openList.begin();
		openList.erase(openList.begin());

		int cur_x = current.x;
		int cur_y = current.y;

		closedList[cur_y][cur_x] = true;

		float nf, ng, nh;

		for (int i = 0; i < 4; ++i) {
			int new_x = cur_x + this->m_dx1[i];
			int new_y = cur_y + this->m_dy1[i];

			if (this->isInGround(mapInfo.map_col, mapInfo.map_row, new_x, new_y)) {
				if (this->isDestinationNode(mapInfo.dest_x, mapInfo.dest_y, new_x, new_y)) {
					cell[new_y][new_x].parent_x = cur_x;
					cell[new_y][new_x].parent_y = cur_y;

					this->TraceMinimumPath(cell, { mapInfo.dest_x, mapInfo.dest_y });

					return true;
				}
				else if (!closedList[new_y][new_x] &&
					this->isUnBlockedNode(ptDecl, mapInfo.mapInfo, new_x, new_y)) {
					ng = cell[cur_y][cur_x].g + 1.000f;
					nh = ((float)std::sqrt((float)std::pow(new_x - mapInfo.dest_x, 2)
						+ (float)std::pow(new_y - mapInfo.dest_y, 2)));
					nf = ng + nh;

					if (cell[new_y][new_x].f == INF || cell[new_y][new_x].f > nf) {
						cell[new_y][new_x].g = ng;
						cell[new_y][new_x].h = nh;
						cell[new_y][new_x].f = nf;

						cell[new_y][new_x].parent_x = cur_x;
						cell[new_y][new_x].parent_y = cur_y;

						CostCoord bVertex;
						bVertex.cost = nf;
						bVertex.x = new_x;
						bVertex.y = new_y;

						openList.insert(bVertex);
					}
				}
			}
		}

		for (int i = 0; i < 4; ++i) {
			int new_x = cur_x + this->m_dx2[i];
			int new_y = cur_y + this->m_dy2[i];

			if (this->isInGround(mapInfo.map_col, mapInfo.map_row, new_x, new_y)) {
				if (this->isDestinationNode(mapInfo.dest_x, mapInfo.dest_y, new_x, new_y)) {
					cell[new_y][new_x].parent_x = cur_x;
					cell[new_y][new_x].parent_y = cur_y;

					this->TraceMinimumPath(cell, { mapInfo.dest_x, mapInfo.dest_y });

					return true;
				}
				else if (!closedList[new_y][new_x] &&
					this->isUnBlockedNode(ptDecl, mapInfo.mapInfo, new_x, new_y)) {
					ng = cell[cur_y][cur_x].g + 1.414f;
					nh = ((float)std::sqrt((float)std::pow(new_x - mapInfo.dest_x, 2)
						+ (float)std::pow(new_y - mapInfo.dest_y, 2)));
					nf = ng + nh;

					if (cell[new_y][new_x].f == INF || cell[new_y][new_x].f > nf) {
						cell[new_y][new_x].g = ng;
						cell[new_y][new_x].h = nh;
						cell[new_y][new_x].f = nf;

						cell[new_y][new_x].parent_x = cur_x;
						cell[new_y][new_x].parent_y = cur_y;

						CostCoord bVertex;
						bVertex.cost = nf;
						bVertex.x = new_x;
						bVertex.y = new_y;

						openList.insert(bVertex);
					}
				}
			}
		}
	}


	return false;
}

void HeuristicClass::TraceMinimumPath(std::vector<std::vector<CellDetails>> cell, Coord dest) {
	std::stack<Coord> TrackingStack;
	std::queue<Coord> TrackingQueue;
	int cur_x, cur_y;

	cur_x = dest.x;
	cur_y = dest.y;

	TrackingStack.push({ cur_x, cur_y });

	while (!(cell[cur_y][cur_x].parent_x == cur_x &&
		cell[cur_y][cur_x].parent_y == cur_y)) {
		int temp_x = cell[cur_y][cur_x].parent_x;
		int temp_y = cell[cur_y][cur_x].parent_y;

		cur_x = temp_x;
		cur_y = temp_y;

		TrackingStack.push({ cur_x, cur_y });
	}

	while (!TrackingStack.empty()) {
		TrackingQueue.push(TrackingStack.top());
		TrackingStack.pop();
	}

	this->m_TrackedPath = TrackingQueue;

	return;
}

std::queue<Coord> HeuristicClass::GetQueue() {
	return (this->m_TrackedPath);
}

bool HeuristicClass::isUnBlockedNode(PointDecl ptDecl, Vec2Map Map, int cur_x, int cur_y) {
	return (Map[cur_y][cur_x] == ptDecl.Void);
}

bool HeuristicClass::isDestinationNode(int dest_x, int dest_y, int cur_x, int cur_y) {
	return ((dest_x == cur_x) && (dest_y == cur_y));
}

bool HeuristicClass::isInGround(int map_col, int map_row, int cur_x, int cur_y) {
	return (((0 <= cur_x) && (cur_x < map_col)) && ((0 <= cur_y) && (cur_y < map_row)));
}