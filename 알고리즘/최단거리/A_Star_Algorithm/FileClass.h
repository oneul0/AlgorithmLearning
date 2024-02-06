/* < FileClass.h > */

#pragma once

#include "TypeDecl.h"

#include <vector>
#include <string>
#include <fstream>

class FileClass {
public:
	FileClass();
	FileClass(const FileClass&);
	~FileClass();

	bool RoadMap(PointDecl, const char*);
	Vec2MapInfo GetVec2Map();

private:
    Vec2MapInfo m_MapInfo;
};
