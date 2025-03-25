import pytest, glob

pytest.main(["-k"] + glob.glob("**/*.py", recursive=True))