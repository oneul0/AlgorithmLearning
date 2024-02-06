/* < AstarClass.h > */

#pragma once

#include "FileClass.h"
#include "HeuristicClass.h"
#include "TypeDecl.h"

#include <iostream>

class AstarClass {
public:
	AstarClass();
	AstarClass(const AstarClass&);
	~AstarClass();

	bool Initialize(PointDecl, const char*);
	void Shutdown();

	void Run();
private:
	FileClass* m_file_class;
	HeuristicClass* m_heuristic_class;

	PointDecl m_PtDecl;

};
