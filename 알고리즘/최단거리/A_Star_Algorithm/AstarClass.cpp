/* < AstarClass.cpp > */

#include "AstarClass.h"

AstarClass::AstarClass() {
	this->m_file_class = 0;
	this->m_heuristic_class = 0;
}

AstarClass::AstarClass(const AstarClass&) {
	return;
}

AstarClass::~AstarClass() {
	return;
}

bool AstarClass::Initialize(PointDecl ptDecl, const char* mapFileName) {
	this->m_PtDecl = ptDecl;

	bool result;

	this->m_file_class = new FileClass;
	if (!this->m_file_class) {
		return false;
	}

	result = this->m_file_class->RoadMap(ptDecl, mapFileName);
	if (!result) {
		return false;
	}

	this->m_heuristic_class = new HeuristicClass;
	if (!this->m_heuristic_class) {
		return false;
	}

	return true;
}

void AstarClass::Shutdown() {
	if (this->m_file_class) {
		delete this->m_file_class;
		this->m_file_class = 0;
	}

	if (this->m_heuristic_class) {
		delete this->m_heuristic_class;
		this->m_heuristic_class = 0;
	}

	return;
}

void AstarClass::Run() {
	std::queue<Coord> queue;
	bool result;

	Vec2MapInfo mapInfo = this->m_file_class->GetVec2Map();
	if (mapInfo.mapInfo.empty()) {
		return;
	}

	result = this->m_heuristic_class->BeginSearch(this->m_PtDecl, mapInfo);
	
	switch (result) {
	case false:
		std::cout << "올바른 맵의 정보가 아닙니다." << std::endl;
		break;

	case true:
		queue = this->m_heuristic_class->GetQueue();
		break;

	}
    if (result) {
		while (!queue.empty()) {
			Coord coord = queue.front();
			queue.pop();
			mapInfo.mapInfo[coord.y][coord.x] = this->m_PtDecl.TracedPath;
		}

		for (int y = 0; y < mapInfo.map_row; ++y) {
			for (int x = 0; x < mapInfo.map_col; ++x) {
				std::cout << mapInfo.mapInfo[y][x] << ' ';
			}
			std::cout << std::endl;
		}
	}

	return;
}