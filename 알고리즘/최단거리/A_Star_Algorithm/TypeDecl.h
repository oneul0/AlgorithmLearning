/* <TypeDecl.h> */

#pragma once

#include <vector>
#include <string>

#include <conio.h>

constexpr float INF = 100000000.0f;
#define BLOCK int _ = _getch()

using Vec2Map = std::vector<std::vector<std::string>>;

/* Vec2MapInfo: 맵정보, 맵의 최대크기, 맵의 출발지점, 맵의 도착지점 */
struct Vec2MapInfo {
    Vec2Map mapInfo;

    int map_col;
    int map_row;

    int beg_x;
    int beg_y;

    int dest_x;
    int dest_y;

};

/* CostCoord: 한 정점의 좌표와 비용 */
struct CostCoord {
	float cost;
	int x, y;
};

/* Coord: 한 정점의 좌표 */
struct Coord {
	int x, y;
};

/* CellDetails: 비용과 부모노드 */
struct CellDetails {
	float f, g, h;
	int parent_x, parent_y;
};

/* PointDecl: 맵에 표기 되어있는 문자의 역할 */
struct PointDecl {
	std::string BeginPoint, DestinationPoint, Void, Wall, TracedPath;
};