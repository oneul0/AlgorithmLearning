/* < main.cpp > */

#include "AstarClass.h"

int main(int argc, char** argv) {
	AstarClass* astar_class = new AstarClass;

	PointDecl pDecl;
	pDecl.BeginPoint = "@";
	pDecl.DestinationPoint = "$";
	pDecl.TracedPath = "*";
	pDecl.Void = "+";
	pDecl.Wall = "#";

	if (astar_class->Initialize(pDecl, "sample_map.txt")) {
		astar_class->Run();
	}
	
	astar_class->Shutdown();
	delete astar_class;
	astar_class = 0;

	BLOCK;

	return 0;
}