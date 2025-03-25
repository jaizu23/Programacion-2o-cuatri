import pytest, glob

pytest.main(glob.glob("**/test_*.py", recursive=True))