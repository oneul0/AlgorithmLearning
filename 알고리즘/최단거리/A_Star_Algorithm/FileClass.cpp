/* < FileClass.cpp > */

#include "FileClass.h"

FileClass::FileClass() {
	memset(&this->m_MapInfo, 0x00, sizeof(Vec2MapInfo));

	return;
}

FileClass::FileClass(const FileClass&) {
	return;
}

FileClass::~FileClass() {
	return;
}

bool FileClass::RoadMap(PointDecl ptDecl, const char* mapFileName) {
    std::ifstream mapFile(mapFileName);

    if(mapFile.fail()){
        return false;
    }
    if(!mapFile.is_open()){
        return false;
    }
    
    Vec2MapInfo mapInfo;
        mapFile >> mapInfo.map_col >> mapInfo.map_row;

        Vec2Map Map(mapInfo.map_row, std::vector<std::string>(mapInfo.map_col));
        for(int y = 0; y < mapInfo.map_row; ++y){
            for(int x = 0; x < mapInfo.map_col; ++x){
                mapFile >> Map[y][x];

                if(Map[y][x] == ptDecl.BeginPoint){
                    mapInfo.beg_x = x;
                    mapInfo.beg_y = y;

                    Map[y][x] = ptDecl.Void;
                }
                if(Map[y][x] == ptDecl.DestinationPoint){
                    mapInfo.dest_x = x;
                    mapInfo.dest_y = y;

                    Map[y][x] = ptDecl.Void;
                }
            }
        }

        mapInfo.mapInfo.clear();
        mapInfo.mapInfo = Map;
        this->m_MapInfo = mapInfo;

        return true;
}

Vec2MapInfo FileClass::GetVec2Map(){
    return (this->m_MapInfo);
}
