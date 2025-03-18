import pytest, glob

pytest.main(glob.glob("**/*.py", recursive=True))